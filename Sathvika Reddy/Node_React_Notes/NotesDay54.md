# Fetch API (To call to serverside api’s):

### 1. Get array of Person objects inside a JSON object

#### Filename: `Family.java`

```java
public class Family {
    private Person[] members;
    public Person[] getMembers() {
        return members;
    }
    public void setMembers(Person[] members) {
        this.members = members;
    }
}
```

#### Filename: `TestController.java`

```java
@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
    @GetMapping("t9")
    public Family test9() {
        Person p1 = new Person();
        p1.setFirstName("abc");
        p1.setLastName("xyz");
        p1.setAge(22);

        Person p2 = new Person();
        p2.setFirstName("test1");
        p2.setLastName("hello");
        p2.setAge(24);

        Person p3 = new Person();
        p3.setFirstName("ramu");
        p3.setLastName("rao");
        p3.setAge(23);

        Person[] persons = {p1, p2, p3};
        Family obj = new Family();
        obj.setMembers(persons);
        return obj;
    }
}
```

#### Filename: `src/Test9.js`

```javascript
import { useState } from "react";
import Test9Child from "./Test9Child";

export default function Test9() {
    const [persons, setPersons] = useState([]);
    const callToApi = () => {
        fetch('http://localhost:9090/test/t9')
            .then(response => response.json())
            .then(data => {
                console.log(data.members);
                setPersons(data.members);
            })
            .catch(error => console.log(error))
    }
    return (<>
        {persons.map(person => <Test9Child person={person} />)}
        <button onClick={callToApi} type='button'>Call to API</button>
    </>)
}
```

#### Filename: `src/Test9Child.js`

```javascript
export default function Test9Child({ person }) {
    return (<>
        <h1>First Name : {person.firstName}</h1>
        <h1>Last Name : {person.lastName}</h1>
        <h1>Age : {person.age}</h1>
        <hr />
    </>)
}
```

---

### 2. Get multiple Person objects inside a HashMap

#### Filename: `SimpleFamily.java`

```java
package com.example.app1;
import java.util.Map;

public class SimpleFamily {
    private Map<String, Person> members;
    public void setMembers(Map<String, Person> members) {
        this.members = members;
    }
    public Map<String, Person> getMembers() {
        return members;
    }
}
```

#### Filename: `TestController.java`

```java
@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
    @GetMapping("t10")
    public SimpleFamily test10() {
        Person p1 = new Person();
        p1.setFirstName("abc");
        p1.setLastName("xyz");
        p1.setAge(22);

        Person p2 = new Person();
        p2.setFirstName("test1");
        p2.setLastName("hello");
        p2.setAge(24);

        Person p3 = new Person();
        p3.setFirstName("ramu");
        p3.setLastName("rao");
        p3.setAge(23);

        Map<String, Person> map = new HashMap<>();
        map.put("husband", p1);
        map.put("wife", p2);
        map.put("child", p3);

        SimpleFamily obj = new SimpleFamily();
        obj.setMembers(map);
        return obj;
    }
}
```

#### Filename: `src/Test10.js`

```javascript
import { useState } from "react";
import Test9Child from "./Test9Child";

export default function Test10() {
    const [persons, setPersons] = useState({});
    const callToApi = () => {
        fetch('http://localhost:9090/test/t10')
            .then(response => response.json())
            .then(data => setPersons(data.members))
            .catch(error => console.log(error))
    }
    return (<>
        {Object.entries(persons).map(([key, value]) =>
            <>{key}: <Test9Child person={value} /></>
        )}
        <button onClick={callToApi}>Get Data</button>
    </>)
}
```

---

### 3. Get a List which contains multiple HashMaps

#### Filename: `Community.java`

```java
package com.example.app1;
import java.util.List;
import java.util.Map;

public class Community {
    private List<Map<String, String>> persons;
    public void setPersons(List<Map<String, String>> persons) {
        this.persons = persons;
    }
    public List<Map<String, String>> getPersons() {
        return persons;
    }
}
```

#### Filename: `TestController.java`

```java
@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
    @GetMapping("t11")
    public Community test11() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("firstName", "Ramu");
        map1.put("lastName", "Rao");
        map1.put("address", "BTM");

        Map<String, String> map2 = new HashMap<>();
        map2.put("firstName", "Kumar");
        map2.put("lastName", "Rao");
        map2.put("address", "JP Nagar");

        Map<String, String> map3 = new HashMap<>();
        map3.put("firstName", "Swathi");
        map3.put("lastName", "Kiran");
        map3.put("address", "Jaya Nagar");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);

        Community community = new Community();
        community.setPersons(list);
        return community;
    }
}
```

#### Filename: `src/Test11.js`

```javascript
import { useState } from "react";

export default function Test11() {
    const [list, setList] = useState([]);
    const callToApi = () => {
        fetch('http://localhost:9090/test/t11')
            .then(response => response.json())
            .then(data => setList(data.persons))
            .catch(error => console.log(error))
    }
    return (<>
        {list.map((item, index) =>
            <h1>
                {Object.entries(item).map(([key, value]) =>
                    <>{key} : {value}, </>
                )}
                <hr />
            </h1>
        )}
        <button onClick={callToApi}>Get Data</button>
    </>)
}
```

---

