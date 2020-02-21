
## What it is?  
Long story short, it's a utility for creating transform&validation sequence for values.  
    
## How to use  
1. Create your own `ActionsExecutor` object  
```java  
ActionsExecutor<String, Integer> actionsExecutor = new ActionsExecutor<>();  
```  
2. Add few `RuleAction` actions for check value  
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
5. And some more rules  
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
checkActionsExecutor = new ActionsExecutor<String, Integer>()
   .add(new NotNullRule<String>())
   .add(new NotEmptyRule())
   .add(new LengthRule(2, 6))
   .add(new StringToIntConverter("Must contains only digits!"))
   .add(new RangeRule<>(2, 20, false))
   .add(new IntToStringConverter())
   .setListener(new AbstractActionsListener() {
       @Override
       public void onSuccess(Integer value) {
           Toast.makeText(DemoActivity.this, String.format("It's all good! Value %d", value), Toast.LENGTH_LONG).show();
       }

       @Override
       public void onError(ChainActionException convertException) {
           Toast.makeText(DemoActivity.this,String.format("Sequence failed! %s", convertException.getErrorMessage()), Toast.LENGTH_LONG).show();
       }
   })
   .run("123");
```
Or follow the alternative way
```java
...
ActionsResult<Integer> result = actionsExecutor.run("123");  
  
if (result.isCorrect()) {  
    System.out.println(String.format("It's all good! Value %d", result.getValue()));  
} else {  
    System.out.println(String.format("Sequence failed! %s", result.getErrorMessage()));  
}
```

### Single action example
In case you need to run a single action.
```java
int value = ...;
ActionsResult<Integer> result = ActionsExecutor.single(new RangeRule<>(2, 20, false), value)
if (result.isCorrect()) {  
    // todo: if value in range [2, 20]
}
```

## Default converters  
For simple converting there are few default converters:  
* `RegexReplaceConverter` - replace all sequence of characters that were defined by regex to some replacement
* `IntToStringConverter` - converting Int to String
* `StringToIntConverter` - converting String to Int
  
## Default rules  
Default data checkers:  
* `RegexRule` - checking is it string matching a regex template
* `LengthRule` - checking the length of a string  
* `NotEmptyRule` - checking string for emptiness  
* `RangeRule` - check if `Comparable<T>` value is between range borders  
* `NotNullRule` - checking object for null  

## How to setup
Add it in your root build.gradle:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to your project build.gradle file:
```groovy
dependencies {
    implementation "com.github.wiskiw:Value-Validator:{$version}"
}
```
Replace `version` with last release version [![](https://jitpack.io/v/wiskiw/Value-Validator.svg?style=flat-square)](https://jitpack.io/#wiskiw/Value-Validator)
  
## Contacts & Info  
Have any questions or suggestions? Chat me [telegram](https://t.me/wiski_w) or mail to ayablonski23@gmail.com