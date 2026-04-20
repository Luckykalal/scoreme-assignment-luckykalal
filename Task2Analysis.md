# Task 2 - ConcurrentModificationException

## Cause:
ConcurrentModificationException occurs when a collection is modified while iterating.

## Example Issue:
for (Transaction t : list) {
    list.remove(t);
}

## Fix:
Use Iterator:
Iterator<Transaction> it = list.iterator();
while (it.hasNext()) {
    Transaction t = it.next();
    if (condition) {
        it.remove(); // FIX
    }
}
