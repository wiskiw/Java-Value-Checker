
## What it is?  
Long story short, it's a utility for creating transform&validation sequence for values.  
    
## How to use  
1. Create your own `ActionsExecutor` object  
```java  
ActionsExecutor actionsExecutor = new ActionsExecutor();  
```  
2. Add few `ChainCheckAction` actions for check value  
```java  
actionsExecutor  
    .add(new NotNullRule<String>("ALARMA! Value cannot be null!"))
    .add(new NotEmptyRule("String must not be empty! Check input value.")) 
    ...
 ```  
 
3. Add data type converter  
```java  
actionsExecutor.add(new StringToIntConverter());  
```  
5. And some more checkers  
```java  
actionsExecutor.add(new RangeRule(6, 12, "Value must be in [6, 12] range"));  
```  
6. And finally, start your sequence by calling `chainExecutor.run(value)` with source value to fetch the converted result  

```java  
ActionsResult<Integer> result = actionsExecutor.run(value); 
```  

7. To check if the sequence was completed sequentially call `result.isCorrect()`.   
To extract converted value use `result.getValue()`. Or take error message list by `result.getFailedMessages()`.  
  
Also you can create your own data converters and validators actions by expanding `ChainCheckAction<T>` and `ChainConvertAction<A, B>` classes.  
    
### Full example
```java
ActionsExecutor actionsExecutor = new ActionsExecutor()  
    .add(new NotNullRule<String>("ALARMA! Value cannot be null!"))
    .add(new NotEmptyRule("String must not be empty! Check input value."))
    .add(new StringToIntConverter())
    .add(new RangeRule(6, 12, "Value must be in [6, 12] range"));
  
ActionsResult<Integer> result = actionsExecutor.run("123");  
  
if (result.isCorrect()) {  
    System.out.println(String.format("It's all good! Value %d", result.getValue()));  
} else {  
    System.out.println(String.format("Sequence failed! %s", result.getErrorMessage()));  
}
```

## Default converters  
For simple converting there are few default converters:  
* `IntToStringConverter` - converting Int to String  
* `StringToIntConverter` - converting String to Int   
  
## Default checkers  
Default data checkers:  
* `ConvertibleRule` - checking if value can be converted using specified converter
* `RegexRule` - checking is it string matching a regex template
* `LengthRule` - checking the length of a string  
* `NotEmptyRule` - checking string for emptiness  
* `RangeRule` - check if `Comparable<T>` value is between range borders  
* `NotNullRule` - checking object for null  
  
## Contacts & Info  
Have any questions or suggestions? Chat me [telegram](https://t.me/wiski_w) or mail to ayablonski23@gmail.com