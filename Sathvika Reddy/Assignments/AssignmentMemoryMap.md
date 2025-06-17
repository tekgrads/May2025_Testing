
# Java Memory Structure Representation

## Stack

```
main
├── args : null
└── sa   : → SavingsAccount (in Heap)
```

## Heap

### : SavingsAccount
- interestRate: `0.05`
- balance: `1000.0`

### : BankAccount
- accountNumber: `123456`
- accountHolderName: `"John Doe"`
- bankName: `"ABC Bank"`

## Class Area

- BankAccount
- SavingsAccount
