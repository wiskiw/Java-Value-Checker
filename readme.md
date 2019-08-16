## What it is?
Long story short, it's a utility for creating transform&validation sequence for values.
  
## Usage example
1. Create your own `ActionChainExecutor` object
```java
ActionChainExecutor chainExecutor = new ActionChainExecutor();
```
2. Add few `ChainCheckAction` actions for check value
```java
chainExecutor
	.add(new NotNullChecker<String>("ALARMA! Value cannot be null!"))
	.add(new NotEmptyChecker("String must not be empty! Check input value."))
	...
```
3. Add data type converter
```java
chainExecutor.add(new StringToIntConverter());
```
4.  And some more checker
```java
chainExecutor.add(new RangeChecker(6, 12, "Value must be in [2, 20] range"));
```
5. And finally, start your sequence by calling `chainExecutor.run(value)` with source value to fetch the converted result
```java
ChainActionResult<Integer> result = chainExecutor.run(value); 
```
Also you can create your own data converters and validators actions by expanding `ChainCheckAction<T>` and `ChainConvertAction<A, B>` classes.
  
## Default converters
For simple converting there are few default converters:
* `IntToStringConverter` - converting Int to String
* `StringToIntConverter` - converting String to Int 

## Default checkers
Default data checkers:
* `LengthChecker` - checking the length of a string
* `NotEmptyChecker` - checking string for emptiness
* `OnlyDigitsChecker` - check if string contains only digits characters (0-9)
* `RangeChecker` - check if `Comparable<T>` value is between range borders
* `NotNullChecker` - checking object for null

## Contacts & Info
Have any questions or suggestions? Chat me [telegram](https://t.me/wiski_w) or mail to ayablonski23@gmail.com