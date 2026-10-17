# Dynamic Programming (DP)

A practical guide to recognizing, designing, implementing, and improving dynamic-programming solutions.

## 1. What dynamic programming is

Dynamic programming solves a problem by expressing it in terms of smaller subproblems, solving each needed subproblem once, and reusing its answer. It is useful when:

1. **The problem has optimal substructure:** an answer can be built from answers to smaller states.
2. **Subproblems overlap:** the same smaller state would otherwise be solved repeatedly.

DP is not a special kind of loop. It is a way to define states and relationships between them. Memoization and tabulation are two ways to evaluate those relationships.

### DP, recursion, and greedy algorithms

- Plain recursion may repeat work. Memoization caches recursive answers.
- Tabulation computes states in an order that makes their dependencies available.
- Greedy algorithms commit to a locally attractive choice. They need a proof that this choice can be part of an optimal answer. DP keeps multiple relevant possibilities when such a commitment is not justified.

## 2. The five questions for every DP

Before coding, write down these items explicitly.

1. **State:** What exact subproblem does each index or parameter describe?
2. **Choices:** What decisions can be made from this state?
3. **Transition:** How does each choice lead to smaller states, and how are their answers combined?
4. **Base cases:** What are the smallest or impossible states, and what are their answers?
5. **Evaluation order:** In what order can each state be computed from its dependencies?

Also decide whether the problem asks to **maximize/minimize**, **count**, **check possibility**, or **construct an answer**. This determines how transitions combine results.

## 3. A repeatable workflow

1. Define a brute-force recursive solution from the problem statement.
2. Identify the parameters that uniquely describe a subproblem.
3. Check whether different recursive paths reach the same state.
4. Write the recurrence and base cases mathematically or in plain language.
5. Memoize the recursive solution. This is often the easiest version to verify.
6. Convert it to a table if needed, choosing an order that computes dependencies first.
7. Check bounds, impossible states, and whether the answer is at the final state or an aggregate over states.
8. Reduce memory only after the full recurrence is clear.

For each transition, ask: **What does this state mean? Why does every valid solution appear in one of these choices? Why can no invalid solution be introduced?** These questions help catch missing choices and incorrect recurrences.

## 4. Example: Fibonacci

Define `dp[n]` as the nth Fibonacci number. For `n >= 2`, the last step comes from either of the two previous values:

```text
dp[0] = 0
dp[1] = 1
dp[n] = dp[n - 1] + dp[n - 2]
```

The direct recursive definition repeats work. A table computes each value once in increasing order. Time is `O(n)`; the last two values alone are enough, so space can be `O(1)`.

This example is small, but it demonstrates the core process: define what a state means, derive its transition, set bases, and compute dependencies first.

## 5. Memoization and tabulation

### Top-down: recursion plus memo

Write a recursive function for a state. Before solving it, return a cached value if present; otherwise compute, save, and return the result.

```java
int solve(int state) {
    if (isBaseCase(state)) return baseValue(state);
    if (memo[state] != UNKNOWN) return memo[state];

    int answer = combine(solve(smallerState1), solve(smallerState2));
    memo[state] = answer;
    return answer;
}
```

Use a distinct `UNKNOWN` marker. Zero may itself be a valid answer. For multidimensional states, memoize every parameter that affects the result.

### Bottom-up: tabulation

Initialize base states, then fill the table in dependency order. A state must never read a value that has not been computed.

Top-down is often easier to derive and may visit only reachable states. Bottom-up avoids recursion overhead and makes iteration and memory reduction clearer. Both implement the same recurrence.

## 6. Common state shapes and patterns

These are starting points, not templates to apply blindly. Define the state in the context of the exact problem.

### A. One-dimensional prefix DP

State often describes the best answer using the first `i` items, or the answer ending at index `i`.

Examples: climbing stairs, house robber, minimum cost to reach a position.

**Watch the meaning:** “best using the prefix” and “best ending here” are different states and have different transitions.

### B. Grid DP

State often describes reaching a cell `(r, c)`. A transition comes from allowed predecessor cells, such as above and left.

Examples: unique paths, minimum path sum, obstacle paths.

For counting, add path counts. For minimizing cost, take the minimum predecessor cost and add the current cell cost. Initialize borders and blocked cells deliberately.

### C. Knapsack and subset DP

State often uses an item index and a remaining capacity, sum, or target.

- **0/1 knapsack:** each item is chosen at most once.
- **Unbounded knapsack:** an item can be chosen repeatedly.
- **Subset sum:** determine whether selected values can total a target.
- **Coin change:** count combinations, count ordered sequences, or minimize coin count; these are different problems with different loop order or transitions.

For a 1D 0/1 knapsack table, capacities are typically iterated downward so the current item cannot be reused. For unbounded use, iterating upward permits reuse. This direction comes from the dependency, not from a memorized rule.

### D. Sequence and subsequence DP

State may track a prefix of one or more sequences, or the best subsequence ending at an index.

Examples: longest increasing subsequence (LIS), longest common subsequence (LCS), edit distance.

LIS has an `O(n^2)` DP where `dp[i]` is the longest increasing subsequence ending at `i`; a faster `O(n log n)` method tracks tails. LCS and edit distance commonly use two indices, with transitions based on whether the current characters match.

### E. String DP

State often represents a prefix pair `(i, j)` or an interval `[left, right]`.

Examples: edit distance, wildcard matching, palindromic subsequences, word break.

Be precise about whether indices are inclusive or a prefix length. Prefix lengths `i` and `j` make empty-prefix base cases easier to express.

### F. Interval DP

State represents the answer for a range, such as `dp[left][right]`. Try a final split or final operation, then combine answers for smaller intervals.

Examples: matrix-chain multiplication, burst balloons, optimal merging, palindrome partitioning.

Intervals are commonly computed by increasing length so shorter intervals are ready first. Handle empty or single-element intervals as base cases.

### G. Tree DP

State describes the answer for a subtree, sometimes with a small condition such as whether the current node is selected. Combine child states after processing children.

Examples: maximum independent set on a tree, tree diameter variants, placing cameras or sensors.

The traversal is usually postorder: child answers first, then the parent. State definitions must account for the condition passed between parent and child.

### H. Bitmask DP

Use a bitmask to represent a subset of a small set. A state may be `dp[mask][last]`, describing a subset already used and the final element or position.

Examples: assignment, traveling salesperson on a small graph, matching.

There are `2^n` subsets, so this is suited to small `n`. Confirm memory and time bounds before choosing it.

### I. State-machine DP

Track a small mode or condition alongside progress, such as holding or not holding a stock, or whether a transaction is available. Transitions represent permitted actions between modes.

Examples: stock trading, cooldowns, alternating subsequences. Clearly define what each mode means at the end of a day or step.

## 7. How the requested result changes the transition

- **Minimum / maximum:** combine choices with `min` / `max`.
- **Number of ways:** add counts from disjoint choices. Ensure choices do not count the same arrangement more than once.
- **Existence:** combine with logical OR; a state is possible if any choice works.
- **Construction:** store a parent or chosen action, then follow those decisions backward from the answer state.

For counts, choose a numeric type that can hold the answer. If the problem specifies a modulus, apply it consistently during additions and multiplications.

## 8. Complexity

Estimate the number of distinct states and the work per state:

```text
time  = number of states × transitions/work per state
space = number of stored states
```

For example, an `n × m` table with a constant number of transitions per cell is typically `O(nm)` time and `O(nm)` space. Include recursion-stack space for top-down solutions.

## 9. Space optimization

Once the recurrence is correct, inspect which earlier states each transition reads. If a row depends only on the previous row, two rows may suffice; if it depends on a few recent values, a few variables may suffice.

When updating a 1D array in place, iteration direction matters. It determines whether a transition reads the previous iteration's value or a value already updated in the current iteration. Derive the direction from the recurrence before changing the code.

Keep the full table when it is needed to reconstruct a path or when it makes the solution clearer and memory limits allow it.

## 10. Common mistakes

- A state omits information that affects future choices.
- A transition misses a choice or counts a choice multiple times.
- Base cases do not match the state definition.
- The table is filled before its dependencies are ready.
- In-place iteration accidentally reuses an item in a 0/1 problem.
- Impossible states are initialized to a value that can win a `min` / `max` comparison.
- A memo table uses a valid answer as its “not computed” marker.
- The code returns the wrong state; the overall answer may be an aggregate over many states.
- A recursive solution has no progress toward a base case or exceeds stack limits.
- Space is optimized before the recurrence and update order are understood.
- A greedy choice is assumed without proving it is safe.

## 11. A DP design worksheet

Fill this out before implementation:

```text
Problem asks for:        min / max / count / existence / construction
State meaning:           dp[...]=
Choices from a state:    
Transition:              
Base cases:              
Evaluation order:        
Final answer location:   
Number of states:        
Work per state:          
Can space be reduced?    Which dependencies must remain available?
```

## 12. Practice progression

Build skill by solving problems in increasing complexity. For each one, write the state and recurrence before coding, then explain why they cover every valid solution.

1. Fibonacci, climbing stairs, min cost climbing stairs.
2. House robber, maximum subarray, decode ways.
3. Grid paths, minimum path sum, triangle minimum path.
4. 0/1 knapsack, subset sum, partition equal subset sum.
5. Coin change (minimum coins and combinations), target sum.
6. LIS, LCS, edit distance.
7. Palindromic subsequence and interval DP problems.
8. Tree DP and bitmask DP.

For each problem, try a recursive definition, memoization, tabulation, and—if appropriate—space optimization. Compare what changes and what stays the same.
