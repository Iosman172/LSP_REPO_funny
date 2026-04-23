Part 1:

Shared Resource #1: nextId

Shared Resource #2: requests

Concurrency Problem: It's possible that a race condition occurs when multiple threads call on addRequest() at the same time.

Why addRequest() is unsafe: addRequest() is unsafe because after it calls getNextId(), it adds to the shared requests list without synchronization. It's a possibility that two threads read the same nextId before either one increments it, which would lead to duplicate request IDs. Also, ArrayList in of itself is not thread safe, so when multiple threads modify it at the same time, we run the risk of corrupting the list or causing unpredictable behavior.

Part 2:

Fix A: This fix isn't correct by itself. While it does protect the incrementing of nextId, which means duplicate IDs are prevented, addRequest() still modifies the shared requests list without synchronization. Because ArrayList isn't thread-safe, multiple threads can still add requests at the same time and cause unsafe behavior.

Fix B: This fix is correct. Synchronizing addRequest() makes the entire operation atomic. This involves getting the next ID, creating the request string, and adding it to the list. Furthermore, because only one thread can run addRequest() on the same RequestManager object at a time, duplicate IDs and unsafe list modification that were possible before are now prevented.

Fix C: This fix is not correct. It only synchronizes access to getRequests(). There is no protection for nextId, which means duplicate IDs are possible, and it doesn't protect the modification of requests inside addRequest(). Also, returning the actual list still exposes the internal ArrayList, so there is a possibility of outside code modifying it unsafely.

Part 3:
No, getNextId() should not be public.

According to Arthur Riel’s heuristics, a class should conceal implementation details and expose only necessary operations. Request ID generation is an internal responsibility of RequestManager. Allowing external code to call on getNextId() directly could result in unused or skipped IDs and disrupt the request creation process. A better design choice would be to make getNextId() private and have addRequest() manage ID creation internally.

Part 4:
Description:
An alternative is to use explicit lock objects rather than the synchronized keyword. For example, Java’s ReentrantLock allows you to manually lock and unlock the critical section in addRequest(). The critical section involves accessing or modifying the shared resources nextId and requests. Locking before and unlocking after this code ensures only one thread executes it at a time.

Code Snippet:
private final Lock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = nextId++;
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}
