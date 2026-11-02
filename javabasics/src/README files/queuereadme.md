# Queues: a complete guide

A queue is a linear data structure that follows **FIFO**: first in, first out. The earliest item added is the first one removed. Queues model waiting lines, scheduling, buffering, and breadth-first search.

## 1. The queue model

```text
front -> [first] [second] [third] <- rear
remove from front; add at rear
```

Core operations are:

- `offer(x)` / `enqueue(x)`: add at the rear.
- `poll()` / `dequeue()`: remove and return the front item.
- `peek()`: inspect the front item without removing it.
- `isEmpty()`: check whether the queue contains no items.

With a suitable implementation, enqueue and dequeue are `O(1)`. Removing index zero from an array-backed list is usually `O(n)` because all remaining entries shift, so it is not a good queue implementation.

## 2. Java queue choices

The `Queue` interface is commonly backed by `ArrayDeque` for ordinary FIFO use:

```java
Queue<String> queue = new ArrayDeque<>();
queue.offer("first");
queue.offer("second");
String front = queue.peek(); // "first"
String removed = queue.poll(); // "first"
```

`offer` and `poll` are useful because they return a status/value rather than throwing for ordinary capacity/empty conditions. `ArrayDeque` does not allow `null`, so `poll() == null` can mean empty. For thread-safe queues, concurrent queues have different guarantees and should be chosen for the concurrency requirements.

## 3. How a circular array queue works

A fixed-size array queue can use two indices: `front` and `size`. The rear position is `(front + size) % capacity`. After removing the front, advance `front` modulo capacity. Modulo allows the indices to wrap to the beginning and reuse freed positions.

Tracking `size` distinguishes empty from full when `front == rear` might describe either condition. Another implementation leaves one slot unused, but effective capacity is then one smaller than the array size. Handle capacity zero separately if it is permitted.

Dynamic circular queues grow by allocating a larger array and copying elements in logical queue order. Growth makes enqueue amortized `O(1)`; a resize operation itself takes `O(n)`.

## 4. Breadth-first search (BFS)

BFS uses a queue to explore nodes in increasing number of edges from the start. With equal edge costs, the first time a node is discovered gives a shortest path by edge count.

```java
Queue<Node> queue = new ArrayDeque<>();
Set<Node> visited = new HashSet<>();
queue.offer(start);
visited.add(start);

while (!queue.isEmpty()) {
    Node node = queue.poll();
    for (Node neighbor : node.neighbors) {
        if (visited.add(neighbor)) { // add returns true only the first time
            queue.offer(neighbor);
        }
    }
}
```

Mark visited when enqueuing. If marking only after dequeueing, multiple parents can enqueue the same node repeatedly. For a graph with `V` vertices and `E` edges, BFS is `O(V + E)` with adjacency lists.

## 5. Level-order traversal of a tree

The queue naturally processes a tree one level at a time. Capture the number of nodes currently in the queue to delimit a level:

```java
while (!queue.isEmpty()) {
    int levelSize = queue.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        level.add(node.value);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
    result.add(level);
}
```

If you use `queue.size()` as a loop condition instead of saving it, newly added children may be processed in the current level by mistake.

## 6. Other queue variants

- **Deque (double-ended queue):** add/remove at both ends. In Java, `ArrayDeque` implements `Deque`. It can act as a queue or stack.
- **Priority queue:** removes the highest- or lowest-priority item rather than the oldest. Java's `PriorityQueue` is a min-heap by default. Its `offer` and `poll` are `O(log n)`, and `peek` is `O(1)`. It is not FIFO.
- **Blocking queue:** waits when empty/full, commonly used to coordinate producer and consumer threads.
- **Monotonic queue/deque:** maintains ordered candidates, often for sliding-window maximum/minimum problems.

Choose by removal rule. If the oldest item leaves first, use FIFO queue; if smallest priority leaves first, use a priority queue; if either end is relevant, use a deque.

## 7. Monotonic deque for sliding windows

For a sliding-window maximum, store indices in decreasing order of their values. Remove expired indices from the front; remove smaller values from the back because the new larger value will outlast and dominate them. The front index is the maximum for the current window. Each index enters and leaves once, so the total work is `O(n)`.

Store indices rather than values so the algorithm can determine when an element falls outside the window. Carefully decide whether equal values should be removed (`<=`) or retained (`<`); either can work depending on how ties are reported.

## 8. Queue applications

- BFS and shortest paths in unweighted graphs.
- Tree level-order traversal.
- Task scheduling and request processing.
- Producer/consumer buffers.
- Simulation of waiting lines.
- Sliding-window extrema with a monotonic deque.

## 9. Common mistakes

- Removing from the back instead of the front for FIFO behavior.
- Using `ArrayList.remove(0)` and accidentally making each dequeue `O(n)`.
- Forgetting empty checks when using operations that throw.
- Marking graph nodes visited only after dequeueing.
- Processing newly enqueued nodes in the same tree level.
- Confusing FIFO queue with a priority queue.
- Incorrect wraparound or full/empty logic in a custom circular queue.
- Assuming BFS gives shortest weighted paths when edge weights differ.

## 10. Practice progression

Implement a circular queue; implement a queue using two stacks; BFS traversal; binary-tree level order; shortest path in a grid; rotten oranges / multi-source BFS; sliding-window maximum; recent-counter simulation; and task scheduling. Trace both the front and rear after each operation.
