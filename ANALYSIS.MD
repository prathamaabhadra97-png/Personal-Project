### Task 2 Analysis

1. **Cause of ConcurrentModificationException:**  
   This occurs when a `ArrayList` is structurally modified (add/remove) while iterated using an `Iterator`.
2. **Code pattern at line 142:**  
   Most likely iterating over an `ArrayList` with a `for-each` loop and calling `transactions.remove(...)` inside the loop.

3. **Minimal fix:**  
   Use `Iterator.remove()` instead of `list.remove()` inside iteration.