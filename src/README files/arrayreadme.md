# Arrays: a complete guide

Arrays are one of the most important data structures in programming. They store a sequence of values and provide direct access by position. Many later structures and algorithms—strings, heaps, hash tables, sorting, dynamic programming, and matrices—build on ideas learned from arrays.

The examples use Java. The central ideas apply to most languages, though exact memory behavior and library names differ.

## 1. What an array is

An array is an ordered collection of elements. Each element has an **index**, usually beginning at `0`:

```text
values: [ 14,  8, 21,  5 ]
index:     0   1   2   3
```

The length is `4`, but the last valid index is `3`, which is `length - 1`. In Java, a primitive array such as `int[]` stores primitive values, while an array of objects such as `String[]` stores references to objects.

```java
int[] scores = {14, 8, 21, 5};
System.out.println(scores[2]); // 21
scores[2] = 30;                // replace the value at index 2
```

An array's length is fixed after creation. You can replace an element, but you cannot grow the same Java array. To grow it, create a larger array and copy values, or use a collection such as `ArrayList<Integer>`.

## 2. Why indexed access is fast

Array elements are laid out so the address of an element can be calculated from the start and its index. Conceptually:

```text
element address = start address + index * element size
```

That is why reading or replacing `array[i]` takes constant time, `O(1)`, regardless of array length. Arrays are excellent when you need frequent indexed access and predictable iteration.

## 3. Creating and using arrays in Java

```java
int[] a = new int[5];       // five zeros
char[] letters = new char[3]; // three '\u0000' characters
String[] names = {"Ava", "Bo"};
int n = a.length;           // arrays use the field length, not length()
```

Java initializes new arrays with default values: numeric primitives become zero, `boolean` becomes `false`, `char` becomes the zero character, and object references become `null`.

Use a loop when you need indices or want to update elements:

```java
for (int i = 0; i < a.length; i++) {
    a[i] += 1;
}
```

Use an enhanced `for` loop when you only need to read each value:

```java
for (int value : a) {
    System.out.println(value);
}
```

Changing the enhanced-loop variable does not change the array element. For example, `value = 10` only changes the local variable.

## 4. Common operations and their costs

Let `n` be the number of elements.

| Operation | Typical cost | Why |
|---|---:|---|
| Read or replace at a known index | `O(1)` | Direct index calculation |
| Scan for a value in an unsorted array | `O(n)` | May inspect every element |
| Insert at the end when there is free capacity | `O(1)` | Write the next slot |
| Insert/delete in the middle | `O(n)` | Later elements must shift |
| Copy all elements | `O(n)` | Every element is visited |
| Sort comparison-based general data | usually `O(n log n)` | Depends on the sorting algorithm |

An ordinary Java array has exactly its allocated capacity. `ArrayList` behaves like a resizable array: appending is amortized `O(1)`, but occasionally it allocates a larger backing array and copies the old values. Inserting or deleting near the front still takes `O(n)` because values shift.

## 5. Searching arrays

### Linear search

Linear search works whether or not the array is sorted:

```java
static int indexOf(int[] a, int target) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == target) return i;
    }
    return -1;
}
```

It uses `O(1)` extra space and `O(n)` time. Return values such as `-1` should clearly mean “not found.”

### Binary search

If the array is sorted, binary search can find a value in `O(log n)` time by halving the remaining search interval each step. Its correctness depends on the sorted-order invariant. See [binarysearchreadme.md](binarysearchreadme.md) for the full guide.

## 6. Inserting, deleting, and shifting

To insert into a fixed array with spare capacity, shift values from right to left so they are not overwritten:

```java
// a has one unused slot; insert value at index pos
for (int i = size; i > pos; i--) {
    a[i] = a[i - 1];
}
a[pos] = value;
size++;
```

To delete at `pos`, shift values from left to right:

```java
for (int i = pos; i < size - 1; i++) {
    a[i] = a[i + 1];
}
size--;
```

The array still physically contains an old value in its last slot, but that slot is outside the logical range `[0, size)`. For object arrays, clear the unused reference when appropriate so it does not keep an object reachable.

## 7. Core array problem-solving patterns

### A. Two pointers

Use two indices when scanning from both ends or maintaining a range. Common examples include reversing an array, checking a palindrome, removing duplicates from a sorted array, and finding a pair in a sorted array.

```java
int left = 0, right = a.length - 1;
while (left < right) {
    int temp = a[left];
    a[left++] = a[right];
    a[right--] = temp;
}
```

The key is to define what each pointer means and what condition makes the loop stop. For a sorted pair-sum search, if the sum is too small, move the left pointer right; if too large, move the right pointer left. Sorted order justifies those moves.

### B. Sliding window

Use a window `[left, right]` for contiguous subarray or substring questions. Expand by moving `right`; when the window violates a condition, move `left` until it is valid again. This is often linear because each pointer only moves forward.

Sliding windows are especially natural when adding/removing an item updates the condition efficiently. For some sum questions with negative values, the usual “shrink while sum is too large” logic is not valid; consider prefix sums or another method.

### C. Prefix sums

Define `prefix[i]` as the sum of the first `i` array values. Then the sum of the half-open range `[left, right)` is `prefix[right] - prefix[left]`.

```java
long[] prefix = new long[a.length + 1];
for (int i = 0; i < a.length; i++) {
    prefix[i + 1] = prefix[i] + a[i];
}
long rangeSum = prefix[right] - prefix[left];
```

The extra leading zero makes boundaries simpler. Precomputation takes `O(n)` and each range-sum query takes `O(1)`. Use `long` if sums may exceed `int`.

### D. Difference arrays

When many operations add a value to an interval, use a difference array. To add `x` to `[left, right]`, add `x` at `left` and subtract `x` at `right + 1` (when that index exists). A prefix pass reconstructs the final values. This transforms repeated range updates from potentially `O(nq)` into `O(n + q)` for `q` updates.

### E. Kadane's algorithm

For the maximum sum of a nonempty contiguous subarray, track the best subarray ending at the current position and the best seen overall:

```java
int endingHere = a[0];
int best = a[0];
for (int i = 1; i < a.length; i++) {
    endingHere = Math.max(a[i], endingHere + a[i]);
    best = Math.max(best, endingHere);
}
```

Initializing from `a[0]` handles arrays containing only negative numbers. Starting `best` at zero would incorrectly allow an empty subarray if the problem requires a nonempty one.

### F. Sorting and frequency counting

Sorting can reveal order, duplicates, or neighboring relationships. A frequency array is useful when values come from a small known range; a hash map is more general. Choose based on the value domain and memory constraints.

### G. In-place transformations

An algorithm is in-place when it uses only a small amount of extra memory, usually `O(1)`. Before overwriting values, decide which original data is still needed. Examples include reversing, partitioning, and moving zeroes.

## 8. Correctness habits and common errors

- **Off-by-one errors:** for length `n`, valid indices are `0` through `n - 1`. A loop that reads `a[n]` is out of bounds.
- **Empty arrays:** do not read `a[0]` before checking `a.length` when empty input is possible.
- **Wrong range convention:** decide whether a range is inclusive `[l, r]` or half-open `[l, r)`. Half-open ranges have length `r - l` and are convenient for prefix sums.
- **Integer overflow:** products and sums can exceed `int`; use `long` before the operation, e.g. `(long) x * y`.
- **Aliasing:** `int[] b = a` does not copy the array; both variables refer to the same object. Use `Arrays.copyOf(a, a.length)` for a copy.
- **Null versus empty:** an array reference can be `null`, while an empty array exists and has length zero. Handle only what the method contract requires.
- **Assuming sorted input:** binary search and many pointer moves require sorted order. Do not use them on arbitrary data without establishing the condition.
- **Mutating input unintentionally:** sorting or writing in place changes the caller's array. Know whether the problem permits that.

## 9. How to approach an array problem

1. Write down the input size, value range, and whether the input is sorted.
2. Clarify whether the result concerns a single element, a pair, a contiguous range, or a subsequence. A subarray must be contiguous; a subsequence need not be.
3. Start with a simple correct approach, often a direct scan or nested loops.
4. Identify repeated work or useful structure: sortedness, a fixed range, a moving window, prefix totals, or limited value domain.
5. State pointer or table invariants in plain language before optimizing.
6. Test mentally with empty/small input, duplicates, all-negative values, boundary positions, and already sorted/reversed data.
7. State time and extra-space complexity.

## 10. Practice progression

Try these in order and explain the pattern used: find maximum/minimum; reverse an array; linear search; move zeroes; remove duplicates from a sorted array; two-sum in sorted input; maximum subarray; best time to buy/sell stock; prefix-sum range queries; product except self; merge sorted arrays; rotate array; longest valid window; and interval range updates.

For each exercise, first write the simple solution, then improve it. Understanding why an optimization works is more valuable than memorizing a code template.
