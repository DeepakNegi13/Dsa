# Binary Search: a complete guide

Binary search is a method for finding a boundary in an ordered search space. Its classic use is searching a sorted array, but the broader idea is to repeatedly discard half of the remaining candidates using a monotonic condition.

## 1. Why binary search is logarithmic

If there are `n` candidates and each comparison eliminates half, after `k` steps about `n / 2^k` candidates remain. Reducing to one gives `k ≈ log2(n)`, so time is `O(log n)`. The algorithm needs an ordering or monotonic property that makes each discard safe.

## 2. Search for an exact value

Use a half-open interval `[left, right)`: `left` is included and `right` is excluded. The candidate indices are always inside that range.

```java
static int binarySearch(int[] a, int target) {
    int left = 0;
    int right = a.length; // exclusive

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (a[mid] == target) return mid;
        if (a[mid] < target) left = mid + 1;
        else right = mid;
    }
    return -1;
}
```

At each iteration, the target—if present—can only be in `[left, right)`. If the midpoint value is too small, the midpoint and everything before it are too small, so `left = mid + 1`. If too large, `mid` and everything after it are too large, so `right = mid`. The interval shrinks until empty or a match is found.

The midpoint expression `left + (right - left) / 2` avoids overflow from adding two large indices. Java's `Arrays.binarySearch` can also search sorted arrays, but its return value for a missing item is an encoded insertion point; check its contract before using it.

## 3. Lower bound: first value greater than or equal to target

Many problems need the first position where `a[i] >= target`, including when the target is absent. This position may equal `a.length`.

```java
static int lowerBound(int[] a, int target) {
    int left = 0, right = a.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (a[mid] < target) left = mid + 1;
        else right = mid;
    }
    return left;
}
```

Afterward, `left == a.length` means no value is at least the target. Otherwise, equality indicates the target occurs. In a sorted array, lower bound is the first duplicate.

## 4. Upper bound: first value greater than target

```java
static int upperBound(int[] a, int target) {
    int left = 0, right = a.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (a[mid] <= target) left = mid + 1;
        else right = mid;
    }
    return left;
}
```

For sorted data, the number of occurrences of `target` is `upperBound - lowerBound`. These searches are often easier to reason about than a special case for finding “the first equal item.”

## 5. The invariant matters more than the template

Before coding, define what the interval contains and what is known about values outside it. For the half-open lower-bound search, the invariant is:

```text
Every index before left has a[i] < target.
Every index at or after right has a[i] >= target.
The answer boundary remains in [left, right].
```

Every update must make progress while preserving the invariant. In an inclusive interval `[left, right]`, updates differ (`right = mid - 1`, for example). Mixing update rules from inclusive and half-open versions can cause off-by-one errors or infinite loops.

## 6. Binary search on the answer

Sometimes the answer is not an element of a sorted array, but a number `x` where feasibility changes monotonically. For example, if a capacity is feasible, any larger capacity may also be feasible:

```text
false false false true true true
                  ^ first feasible value
```

Define `feasible(x)` and binary-search for the first true or last false. You must prove monotonicity. If feasibility changes back and forth, binary search is not valid.

Typical examples: minimum capacity to ship within a deadline, minimum speed to finish tasks, smallest maximum workload after partitioning, and maximum minimum distance among placements. Each feasibility check may itself scan the input, so total complexity is `O(checkCost * log(answerRange))`.

## 7. Searching rotated sorted arrays

A rotated sorted array has two sorted portions, with at most one drop (if values are distinct). At each midpoint, determine which half is sorted and whether the target falls within that half; retain only a half that can contain it. With duplicates, comparisons may not identify the sorted half when `a[left] == a[mid]`; worst-case complexity can degrade to `O(n)`.

## 8. Matrix and custom search spaces

For a matrix whose rows and columns are each sorted, begin at top-right: too large means move left; too small means move down. This uses `O(R + C)` comparisons. If a rectangular matrix is sorted as one flattened sequence, map a virtual index `mid` to `row = mid / columns`, `col = mid % columns` and binary-search `[0, rows * columns)`. Guard zero columns and use a wide integer for the product if dimensions can be large.

## 9. Floating-point binary search

For a numeric answer with tolerance `epsilon`, repeatedly bisect `[low, high]` until the interval width is small enough or a fixed number of iterations has run. A fixed iteration count avoids fragile termination from floating-point rounding. The feasibility condition still must be monotonic.

## 10. Complexity

- Sorted-array exact search or boundary search: `O(log n)` time, `O(1)` extra space iteratively.
- Recursive binary search: `O(log n)` call-stack space.
- Answer search: `O(log(range))` feasibility checks, multiplied by each check's cost.
- Searching a row-and-column sorted matrix by the staircase method: `O(R + C)`.

## 11. Common mistakes

- Searching unsorted data without first establishing a valid monotonic order.
- Using the wrong interval convention or wrong endpoint update.
- Infinite loop when `mid` remains equal to a boundary and the interval is not reduced.
- Returning an arbitrary duplicate when the problem asks for first/last occurrence.
- Forgetting that lower/upper bound may return `n`.
- Overflow in `(left + right) / 2` or in `rows * columns`.
- Assuming a locally sorted half exists in the needed form when duplicates obscure it.
- Applying binary search on the answer without proving feasibility is monotonic.
- Ignoring empty input or endpoint cases.

## 12. A binary-search design checklist

1. What is the ordered search space?
2. What exactly does the returned index/value mean?
3. What is the invariant before and after each iteration?
4. Is the interval inclusive or half-open?
5. Which condition tells me to keep the left or right part?
6. Does each branch strictly shrink the interval?
7. What should happen when the value is absent or the boundary is at an endpoint?
8. Is the monotonic property proved?

## 13. Practice progression

Exact search; first/last occurrence; lower and upper bound; search insert position; integer square root; peak element; rotated sorted array; minimum feasible capacity; split array to minimize largest sum; median of two sorted arrays; and matrix search. For each, write the invariant and explain why the discarded half cannot contain the answer.
