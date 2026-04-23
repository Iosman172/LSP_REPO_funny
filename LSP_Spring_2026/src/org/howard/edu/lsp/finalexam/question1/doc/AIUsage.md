AI Tools Used:
ChatGPT

Prompts Used (2–5 max):
1. https://chatgpt.com/share/69eaa619-0c3c-83ea-86f2-b8f9346d84eb 

How AI Helped (2–3 sentences):
AI helped me check whether my answer correctly identified the concurrency issue in the RequestManager class. It also helped me clarify why the shared resources were nextId and requests, and why nextId++ is not thread-safe.

Reflection (1–2 sentences):
I learned that nextId++ is not atomic because it involves reading, incrementing, and storing a value. I also learned that synchronization needs to protect the full critical section, not just one part of the method.
