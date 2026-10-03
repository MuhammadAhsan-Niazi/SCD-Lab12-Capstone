# Capstone Product Backlog – "EduShop" (simple online store cart)

Estimates use story points (relative complexity: 1, 2, 3, 5, 8).

| ID | User story | Points | Sprint |
|---|---|---|---|
| US-1 | As a shopper, I want to add an item to my cart, so that I can buy it later. | 2 | Sprint 1 |
| US-2 | As a shopper, I want to see my cart total, so that I know what I will pay. | 2 | Sprint 1 |
| US-3 | As a shopper, I want to apply a percentage discount code, so that I save money. | 3 | Sprint 1 |
| US-4 | As a shopper, I want to remove an item from my cart, so that I can change my mind. | 2 | Backlog |
| US-5 | As a shopper, I want to see the cart item count in the header, so that I know the cart is updated. | 1 | Backlog |
| US-6 | As an admin, I want orders stored in a database, so that they survive a restart. | 8 | Backlog |

## Acceptance criteria (done = all criteria pass in an automated test on main)
**US-1**
- Adding an item with quantity ≥ 1 and unit price ≥ 0 stores it in the cart.
- Quantity 0 or less is rejected with an exception; the cart is unchanged.
- Negative unit price is rejected.

**US-2**
- Total equals the sum of unit price × quantity over all items, rounded to 2 decimal places.
- An empty cart has total 0.00.

**US-3**
- A percentage between 0 and 100 (inclusive) reduces the total by that percentage.
- Percentages outside 0–100 are rejected and the previous discount remains.
