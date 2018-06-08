# Jersey validation of resource method return value

The motivation for this POC is that resource method return values
should not go through the same validation process as incoming 
client objects. So I wanted to show another way to do the validation
on the return values. Inspiration is from this [Stack Overflow question][1].

### Run

```bash
mvn jetty:run
```

### cURL

```bash
curl -i http://localhost:8080/api/hello
```

Here is the resource method, annotated with a custom annotation
`@ResponseValid`.

```java
@GET
@ResponseValid
public HelloMessage getSomething() {
    HelloMessage helloMessage = new HelloMessage();
    helloMessage.setMessage("H");
    return helloMessage;
}
```

There should be a constraint violation as the message property
should be minimum of 2 characters. On request, should receive
a response telling you there was an error.

To implement this feature, I used [AOP support from HK2][2]. 
All of implementation is inside the `com.peeskillet.validation`
package.



[1]: https://stackoverflow.com/q/50658396/2587435

[2]: https://javaee.github.io/hk2/aop-example.html