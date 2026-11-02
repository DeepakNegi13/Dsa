# Graph Data Structure: Revision Notes

## 1. What is a graph?

A **graph** is a non-linear data structure used to represent relationships between objects.

- **Vertex (or node):** an object in the graph.
- **Edge:** a connection between two vertices.

For example, cities can be vertices and roads between cities can be edges:

```text
      A ------- B
      |         |
      |         |
      C ------- D
```

In this example, `A`, `B`, `C`, and `D` are vertices. The lines between them are edges.

In mathematical notation, a graph is written as:

```text
G = (V, E)
```

- `V` is the set of vertices.
- `E` is the set of edges.

## 2. Basic terminology

- **Adjacent vertices:** two vertices directly connected by an edge. `A` and `B` are adjacent.
- **Incident edge:** an edge connected to a particular vertex.
- **Degree:** the number of edges connected to a vertex.
- **Path:** a sequence of vertices connected by edges. For example, `A -> B -> D`.
- **Path length:** the number of edges in a path. The path `A -> B -> D` has length `2`.
- **Cycle:** a path that starts and ends at the same vertex without repeating an edge. For example, `A -> B -> D -> C -> A`.
- **Self-loop:** an edge from a vertex to itself, such as `A -> A`.
- **Connected graph:** every vertex can be reached from every other vertex (for an undirected graph).
- **Connected component:** a separate connected part of a graph.
- **Simple graph:** a graph without self-loops or multiple edges between the same pair of vertices.

## 3. Types of graphs

### Undirected graph

An edge has no direction. If `A` is connected to `B`, we can travel in both directions.

```text
A ----- B
```

The edge is represented as `{A, B}`.

### Directed graph

An edge has a direction. `A -> B` does not necessarily mean that `B -> A` exists.

```text
A ----> B
```

The edge is represented as `(A, B)`.

- **In-degree:** number of edges entering a vertex.
- **Out-degree:** number of edges leaving a vertex.

### Weighted and unweighted graphs

- **Unweighted graph:** every edge is treated equally.
- **Weighted graph:** every edge has a value such as distance, cost, or time.

```text
A --5--> B
```

Here, `5` is the weight of the edge.

### Cyclic and acyclic graphs

- **Cyclic graph:** contains at least one cycle.
- **Acyclic graph:** contains no cycle.
- A directed acyclic graph is called a **DAG** (Directed Acyclic Graph).

## 4. Important graph facts

- In an undirected graph, the sum of all vertex degrees is `2 * number of edges`, because every edge touches two vertices.
- A simple undirected graph with `n` vertices can have at most `n * (n - 1) / 2` edges.
- A self-loop contributes `2` to the degree in an undirected graph.
- A graph does not have to be connected.
- A tree is a special graph that is connected and has no cycles.

## 5. Representing a graph in Java

### Adjacency matrix

An adjacency matrix uses a 2D array. `matrix[i][j]` tells whether an edge exists from vertex `i` to vertex `j`.

For an unweighted graph:

```java
int[][] matrix = new int[4][4];

// Add an undirected edge between vertex 0 and vertex 1.
matrix[0][1] = 1;
matrix[1][0] = 1;
```

For a weighted graph, store the weight instead of `1`:

```java
int[][] weightedMatrix = new int[4][4];

weightedMatrix[0][1] = 5;
weightedMatrix[1][0] = 5; // both directions for an undirected graph
```

Complexity:

- Space: `O(V^2)`
- Check whether an edge exists: `O(1)`
- Best for dense graphs (graphs with many edges)

### Adjacency list

An adjacency list stores the neighbors of each vertex. It usually saves space for sparse graphs.

```java
import java.util.ArrayList;
import java.util.List;

int vertices = 4;
List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i < vertices; i++) {
    graph.add(new ArrayList<>());
}

// Add an undirected edge between 0 and 1.
graph.get(0).add(1);
graph.get(1).add(0);

System.out.println(graph.get(0)); // [1]
```

For a directed edge from `0` to `1`, add only:

```java
graph.get(0).add(1);
```

Complexity:

- Space: `O(V + E)`
- Finding all neighbors of a vertex: `O(degree of vertex)`
- Best for sparse graphs

## 6. Adjacency matrix versus adjacency list

| Representation | Space | Check an edge | Suitable for |
|---|---:|---:|---|
| Adjacency matrix | `O(V^2)` | `O(1)` | Dense graphs |
| Adjacency list | `O(V + E)` | `O(degree)` | Sparse graphs |

`V` means the number of vertices and `E` means the number of edges.

## 7. Quick revision checklist

Before solving a graph problem, identify:

1. What are the vertices?
2. What are the edges?
3. Are the edges directed or undirected?
4. Are the edges weighted or unweighted?
5. Can the graph contain cycles?
6. Is the graph guaranteed to be connected?
7. Should the graph be stored as a matrix or a list?

### Do not confuse these terms

- A **vertex** is an object; an **edge** is a connection.
- A **path** may visit different vertices in order; a **cycle** returns to its starting vertex.
- **Degree** is used commonly for undirected graphs; directed graphs use **in-degree** and **out-degree**.
- A **tree** is a type of graph, but every graph is not a tree.