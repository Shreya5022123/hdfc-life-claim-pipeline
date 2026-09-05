# HDFC Life Claim Pipeline

## Complexity Table

| Operation | Time Complexity | Space Complexity |
|---|---|---|
| addFirst | O(1) | O(1) |
| addLast | O(n) | O(1) |
| insertAt | O(n) | O(1) |
| deleteAt | O(n) | O(1) |
| nodeAt | O(n) | O(1) |
| Iterative Reverse | O(n) | O(1) |
| Recursive Reverse | O(n) | O(n) |
| Find Middle | O(n) | O(1) |
| Cycle Detection | O(n) | O(1) |
| Add Two Numbers | O(n) | O(n) |
| Array Stack push/pop/peek | O(1) | O(1) |
| Linked Stack push/pop/peek | O(1) | O(1) |
| Circular Queue enqueue/dequeue | O(1) | O(n) |
| PriorityQueue add/poll | O(log n) | O(n) |

## Linked List vs Array

An array provides O(1) random access, but insertion and deletion may require shifting elements. A linked list requires O(n) time for random access, but insertion and deletion can be performed without shifting elements once the required position is reached. Linked lists also grow dynamically, whereas arrays have a fixed capacity when created.