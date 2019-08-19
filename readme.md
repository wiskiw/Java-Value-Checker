
## What it is?  
Long story short, it's a utility for creating transform&validation sequence for values.  
    
## How to use  
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
5. And some more checkers  
```java  
chainExecutor.add(new RangeChecker(6, 12, "Value must be in [6, 12] range"));  
```  
6. And finally, start your sequence by calling `chainExecutor.run(value)` with source value to fetch the converted result  

```java  
ChainActionResult<Integer> result = chainExecutor.run(value); 
```  

7. To check if the sequence was completed sequentially call `result.isCorrect()`.   
To extract converted value use `result.getValue()`. Or take error message list by `result.getFailedMessages()`.  
  
Also you can create your own data converters and validators actions by expanding `ChainCheckAction<T>` and `ChainConvertAction<A, B>` classes.  
    
### Full example
```java
ActionChainExecutor chainExecutor = new ActionChainExecutor()  
	.add(new NotNullChecker<String>("ALARMA! Value cannot be null!"))
	.add(new NotEmptyChecker("String must not be empty! Check input value."))
    .add(new StringToIntConverter())
    .add(new RangeChecker(6, 12, "Value must be in [6, 12] range"));
  
ChainActionResult<Integer> result = chainExecutor.run("123");  
  
if (result.isCorrect()) {  
	System.out.println(String.format("It's all good! Value %d", result.getValue()));  
} else {  
	System.out.println(String.format("Sequence failed! %s", result.getFailedMessages().toString()));  
}
```

## Default converters  
For simple converting there are few default converters:  
* `IntToStringConverter` - converting Int to String  
* `StringToIntConverter` - converting String to Int   
  
## Default checkers  
Default data checkers:  
* `ConvertibleChecker` - checking if value can be converted using specified converter
* `RegexChecker` - checking is it string matching a regex template
* `LengthChecker` - checking the length of a string  
* `NotEmptyChecker` - checking string for emptiness  
* `RangeChecker` - check if `Comparable<T>` value is between range borders  
* `NotNullChecker` - checking object for null  
  
## Contacts & Info  
Have any questions or suggestions? Chat me [telegram](https://t.me/wiski_w) or mail to ayablonski23@gmail.com