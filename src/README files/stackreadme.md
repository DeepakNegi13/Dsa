# Stacks: a complete guide

A stack is a linear data structure that follows **LIFO**: last in, first out. The most recently added item is the first one removed. A stack is useful for nested work, reversing order, parsing, depth-first search, and maintaining candidates while scanning.

## 1. The stack model

Think of a stack of plates. You add and remove from the same end, called the **top**:

```text
top -> 30  (most recently pushed)
       20
       10  (bottom)
```

Core operations are:

- `push(x)`: put `x` on top.
- `pop()`: remove and return the top item.
- `peek()` / `top()`: inspect the top without removing it.
- `isEmpty()`: check whether there are no items.

These operations are `O(1)` in a typical implementation. A stack is an abstract data type: it describes behavior, not one specific storage layout.

## 2. Implementing stacks in Java

Prefer `ArrayDeque` for most Java stack use. The older `Stack` class extends `Vector` and has legacy behavior that is usually unnecessary.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
int top = stack.peek(); // 20
int removed = stack.pop(); // 20
boolean empty = stack.isEmpty();
```

`ArrayDeque` does not allow `null`. `pop()` and `peek()` throw when empty; use `isEmpty()` or `pollFirst()` if a non-throwing operation is desired. With Java collections, import `java.util.ArrayDeque` and `java.util.Deque`.

A stack can also be implemented with an array plus a `top` index, or with linked nodes. Array-backed stacks have good locality and can resize. A linked stack grows node by node but allocates objects and references. Both provide `O(1)` push/pop (amortized for a resizable array).

## 3. Stack invariants

An invariant is a statement that remains true throughout an algorithm. For a stack, a common invariant is: “The stack contains exactly the unresolved items from the portion already processed.” This helps explain why an item is pushed, when it can be removed, and why the top is the next item to process.

Do not pop before checking that the stack is nonempty. In loops, guard with `!stack.isEmpty()` before calling `peek()` or `pop()`.

## 4. Pattern: matching brackets and nested structures

When scanning text, push an opening delimiter. On a closing delimiter, the stack top must be its matching opener. At the end, the stack must be empty.

```java
static boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) return false;
            char open = stack.pop();
            if ((ch == ')' && open != '(')
                    || (ch == ']' && open != '[')
                    || (ch == '}' && open != '{')) return false;
        }
    }
    return stack.isEmpty();
}
```

This works because the most recent unmatched opener must close first. Time is `O(n)` and extra space is `O(n)`.

## 5. Pattern: monotonic stacks

A monotonic stack keeps values or indices in increasing or decreasing order. While scanning, remove candidates from the top that can no longer be an answer. The new item then becomes the most relevant unresolved candidate.

Common applications include:

- Next greater or next smaller element.
- Daily temperatures / next warmer day.
- Largest rectangle in a histogram.
- Sum of subarray minimums or maximums.
- Previous/next smaller boundaries.

Store **indices** when distance or boundaries matter. For next greater element, a decreasing stack of indices contains items still waiting for a greater value. When the current value is greater than the value at the top index, the current position is its answer. Each index is pushed once and popped at most once, so total time is `O(n)`, even though there is a `while` loop inside the scan.

Be exact about strict versus non-strict comparison (`<` versus `<=`). Duplicates affect which equal value is considered the previous/next boundary and can cause double counting if handled inconsistently.

## 6. Pattern: expression evaluation and parsing

Stacks help evaluate expressions because operators and parentheses have precedence and nesting. Common approaches include converting infix expressions to postfix (shunting-yard) or using two stacks for values and operators. Unary minus, associativity, and parentheses require explicit rules; do not assume a simple left-to-right scan handles them.

For a postfix expression, scan tokens: push operands; when an operator appears, pop its operands in the correct order, apply it, and push the result. For subtraction or division, the first popped value is the right operand.

## 7. Pattern: DFS and backtracking

An iterative depth-first search uses a stack instead of the call stack. Push a start node; repeatedly pop a node, process it, and push eligible neighbors. Mark visited at a consistent point so cycles do not cause endless processing.

Backtracking often uses recursion, but an explicit stack can represent choices and return points when recursion depth is too large. The stack's contents represent work that has been discovered but not completed.

## 8. Pattern: undo and history

An undo feature can push actions onto a history stack and pop the latest action to reverse it. A redo feature often uses a second stack. The exact information stored must be sufficient to reverse an action; storing only the new value may not be enough if the old value is needed.

## 9. Complexity and tradeoffs

For `n` items, a stack uses `O(n)` storage in the worst case. Push, pop, and peek are `O(1)` (amortized push for a dynamic array). A stack intentionally restricts access to the top; if you need arbitrary indexed access, a different structure may fit better.

## 10. Common errors

- Popping or peeking when empty.
- Pushing values when indices are needed for distances or boundaries.
- Using the wrong comparison in a monotonic stack, especially with duplicates.
- Forgetting that `pop()` removes the item.
- Reversing operands during postfix evaluation.
- Marking graph nodes visited too late or inconsistently.
- Assuming every nested problem requires a stack; recursion already uses the call stack.
- Using `java.util.Stack` where `ArrayDeque` is simpler and generally preferred.

## 11. How to recognize a stack problem

Look for “most recent unmatched,” nested delimiters, undoing the latest action, processing an expression, or finding the nearest greater/smaller element in one direction. Ask what remains unresolved as the scan moves forward. If only the newest unresolved item can be resolved next, a stack is a strong candidate.

## 12. Practice progression

Implement a stack; valid parentheses; remove adjacent duplicates; evaluate postfix; daily temperatures; next greater element; simplify a path; minimum stack; largest rectangle in a histogram; and decode a nested string. For monotonic-stack problems, draw the stack after each input item and explain why every pop is safe.
