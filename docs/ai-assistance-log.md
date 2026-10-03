# AI Assistance Log (Additional Task 2)

**Where AI assistance was used:** scaffolding of the Maven project, first drafts of the Cart class and its tests.

**How the output was reviewed and tested before committing:**
1. Read each generated method line by line and checked it against the acceptance criteria in `backlog.md`.
2. Compiled with `javac -Xlint:all` and ran the JUnit suite; the red state was confirmed before each implementation commit.
3. Checked the edge cases the AI did not raise: negative prices (added after review) and the rounding order of the discount.
4. Rewrote the rounding helper after noticing the first draft rounded before applying the discount, which contradicted US-3.
