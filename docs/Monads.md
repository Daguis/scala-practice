# Monads

## Definitions
A monad is a `design pattern` that represents computations defined as a sequence of steps, allowing functions with `incompatible types` to be `composed` by encapsulating them `in a monadic type`.

A `design pattern` in which pipeline implementations are `abstracted` by `wrapping` a value in a specific `type`.

## Monads Parts

### Wrapper Type
The `data structure` that encapsulates a value.

---

### Wrap Function
Takes a `raw value` and places it `into` a `wrapper type`.

---

### Run Function
`Extracts` or processes the `value from` the `wrapper type`.

---

## Maybe Monad

### Essence
- Encapsulating values: (`Just`)
- Handling the absence of a value: (`None`)
- Providing a mechanism (`bind`) to chain computations

---

1. Define a Maybe monad
    ```scala
    sealed trait Maybe[+A] {
    def bind[B](func: A => Maybe[B]): Maybe[B]
    }
    ```

---

2. Define a concrete case for Some value
    ```scala
    case class Just[A](value: A) extends Maybe[A] {
    def bind[B](func: A => Maybe[B]): Maybe[B] = func(value)
    }
    ```

---

3. Define a concrete case for None (empty value)
    ```scala
    case object None extends Maybe[Nothing] {
    def bind[B](func: Nothing => Maybe[B]): Maybe[B] = None
    }
    ```

---

4. Example usage
    ```scala
    val maybeValue = Just(42)
    val result = maybeValue.bind(x => Just(x * 2)) // Result: Just(84)

    val emptyValue: Maybe[Int] = None
    val emptyResult = emptyValue.bind(x => Just(x * 2)) // Result: None
    ```

---

### Sealed Trait

> We use `sealed trait` for `Maybe` to define a type hierarchy. This ensures all implementations of `Maybe` (e.g., `Just` and `None`) are defined in the same file, providing exhaustive pattern matching.

---

### Case Classes

> In Scala, `case class` is used for `Just` and `None`, which makes pattern matching easy and automatically provides implementations for methods like `equals`, `hashCode`, and `toString`.

---

### Bind Method

> The `bind` method represents the core concept of the monad, allowing us to chain computations that might produce a `None` or `Just`.


