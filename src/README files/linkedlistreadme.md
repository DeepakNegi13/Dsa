# Linked Lists: a complete guide

A linked list stores elements in nodes connected by references. It is useful for understanding references, pointer updates, and dynamic structures. The examples use Java.

## 1. The basic model

An array stores values by index. A linked list instead stores each value in a node, and each node points to another node:

```text
head -> [7 | next] -> [12 | next] -> [4 | null]
```

The `head` reference gives access to the first node. In a singly linked list, each node points forward only. The last node's `next` is `null`. A list with no nodes has `head == null`.

```java
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
```

Each node is a separate object. In Java, a reference variable holds a way to reach an object; assigning a node reference copies the reference, not the whole node.

## 2. Singly, doubly, and circular lists

- **Singly linked:** each node has `next`. It is memory-efficient and supports forward traversal.
- **Doubly linked:** each node has `next` and `prev`. It supports traversal in both directions and easier deletion when the node is already known, at the cost of an extra reference and more careful updates.
- **Circular linked:** the final node links back to the first instead of `null`. Traversal needs a stopping condition other than reaching `null`.

## 3. Complexity and when to use a list

| Operation | Singly linked list |
|---|---:|
| Read the element at index `i` | `O(n)` |
| Search by value | `O(n)` |
| Insert at head | `O(1)` |
| Delete at head | `O(1)` |
| Insert after a known node | `O(1)` |
| Delete after a known predecessor | `O(1)` |
| Append | `O(1)` with a maintained tail, otherwise `O(n)` |

Linked lists do not provide fast random access. Arrays and `ArrayList` often perform better for simple iteration because data is stored contiguously and has better cache locality. Choose a linked list when node-based insertion/deletion patterns matter or when the problem specifically requires pointer manipulation.

## 4. Traversing a list

Start at `head` and follow `next` until `null`:

```java
for (ListNode current = head; current != null; current = current.next) {
    System.out.println(current.value);
}
```

Do not advance a node and then expect to recover the previous node in a singly linked list. Keep a `previous` reference if the algorithm needs it.

## 5. Insertion and deletion

### Insert at the front

```java
ListNode node = new ListNode(value);
node.next = head;
head = node;
```

The new node first points to the old head; then `head` is updated. Reversing those assignments loses access to the old list.

### Delete the front node

```java
if (head != null) {
    head = head.next;
}
```

### Insert after a node

```java
ListNode node = new ListNode(value);
node.next = current.next;
current.next = node;
```

Connect the new node to the rest of the list before replacing the predecessor's link.

### Delete after a node

```java
if (current != null && current.next != null) {
    current.next = current.next.next;
}
```

Deleting the head is a special case because there is no predecessor. A dummy node can make head changes uniform.

## 6. Dummy (sentinel) nodes

A dummy node is a temporary node placed before the real head. It simplifies algorithms that may insert or remove the first real node:

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode previous = dummy;
// edit links using previous
head = dummy.next;
```

The dummy is not part of the returned list. It reduces special cases and is commonly used for removing nodes, merging lists, and partitioning.

## 7. Reversing a singly linked list

Maintain `previous`, `current`, and `next`. Save the next node before changing the link, or the rest of the list becomes unreachable:

```java
static ListNode reverse(ListNode head) {
    ListNode previous = null;
    ListNode current = head;

    while (current != null) {
        ListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    return previous;
}
```

The invariant is: `previous` is the reversed portion, and `current` begins the not-yet-reversed portion. Time is `O(n)` and extra space is `O(1)`.

## 8. Fast and slow pointers

Move one pointer by one node and another by two nodes. This pattern finds a middle node and detects cycles.

### Find a middle node

```java
ListNode slow = head;
ListNode fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow is at a middle node
```

For an even-length list, this version returns the second of the two middle nodes. Starting `fast` at `head.next` changes which middle is selected; follow the required convention.

### Detect a cycle (Floyd's algorithm)

If the fast pointer ever equals the slow pointer, a cycle exists. If `fast` reaches `null`, there is no cycle. The loop condition must check both `fast` and `fast.next` before advancing by two.

## 9. Other common list patterns

- **Merge two sorted lists:** repeatedly attach the smaller current node to a result tail. A dummy head makes initialization simple. Attach the remaining suffix when one list ends.
- **Remove the nth node from the end:** use a dummy node and two pointers separated by `n` links. Move both until the front pointer reaches the end; the other pointer is at the predecessor to remove.
- **Palindrome list:** find the middle, reverse the second half, and compare corresponding values. Decide whether the list must be restored afterward.
- **Intersection of two lists:** pointer switching can make two traversals have equal total lengths; compare node identity (`==`), not just values.
- **Cycle entry:** after Floyd's pointers meet, move one pointer to the head and advance both one step at a time; their next meeting is the cycle entry.

## 10. Java reference and mutation pitfalls

- `ListNode b = a` makes `b` refer to the same node as `a`.
- Comparing values is different from comparing nodes. `a == b` checks whether both references point to the same object.
- Reassigning a local `head` does not update a caller's variable unless the new head is returned or stored in a wrapper object.
- A cycle means ordinary `while (node != null)` traversal never ends.
- When relinking nodes, save links before overwriting them.
- In problems that require reusing existing nodes, creating a completely new list may violate the requirement even if the values are correct.
- Java's garbage collector reclaims unreachable nodes; you still need to maintain correct links and avoid accidentally retaining nodes.

## 11. Correctness checklist

Test an empty list, one node, two nodes, head deletion, tail deletion, duplicate values, and a cycle if cycles are in scope. Trace each reference after every assignment. For a mutation, confirm that every intended node remains reachable exactly once and that the final tail points to `null` for a non-circular list.

## 12. Practice progression

Reverse a list; find its middle; merge two sorted lists; remove elements; remove the nth node from the end; detect a cycle; find cycle entry; check a palindrome; find intersection; add numbers represented by lists; reverse nodes in groups; and sort a list. For every problem, draw the nodes and arrows before coding.
