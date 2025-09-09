Class 37:

## 3 types of creation of beans
- `@Autowired`
- 2nd way: annotation based
- 3rd way: java configuration  
  `@Bean`

```java
P HWMesaage getHellowm(String greetingMsg) {
    return new HWM(greetingMsg);
}

Create Maven Project

spring core-2
	•	Ctrl + Shift + O → clean up organized
	•	Ctrl + Shift + F → format code

@Bean

Meaning: we are telling Spring to invoke.
Camel case: HelloWorldMessage

Singleton Beans
	•	How many times you ask your bean factory, it will give same object.
	•	Same object is updated (just bean is updated).

How can we ask Spring to give a new bean?
By prototype
@Scope("prototype")
Whenever we ask, it will give new bean.
Injection by Name
When we have 2 beans of same type as message:
@Qualifier("Hello")

•	@Primary → By default, this bean will be considered if you have 2 beans.

Lazy Beans
If you want to stop the default bean creation and make it created later (last priority):

@Bean
@Lazy
P G getGreets(HW hw) {  
    return new Greets(hw);  
}
@DependsOn
Controls bean creation order flow.
	•	If taskA and taskB are created automatically → taskA created first.
	•	If you want taskB to be created first:

@DependsOn("taskB")
(Spring core) – taskA Java
@Order
Controls bean injection order.
We can control the execution order of beans.

Lifecycle Callbacks
There are certain hooks executed before or after your bean is created:
	•	@PostConstruct → executed after bean got created
	•	@PreDestroy → executed before bean gets destroyed

Project Conversion
Conversion to Spring MVC – MVC has multiple frameworks.