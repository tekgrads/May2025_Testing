import Level2Child from './Level2Child';
export default function Level1Child({firstName, names, person, persons, test, f1}) {
    return (<>
        Level1Child begin <br />
        First Name: { firstName } <br />
        Names: { names.join(", ") } <br />
        Person: { person.firstName } { person.lastName } {person.age}<br />
        Persons: { persons.map(p => (<span key={p.firstName}>{p.firstName} {p.lastName} {p.age}; </span>)) } <br />

        <button type='button' onClick={test}>Button</button><br />
          <button type='button' onClick={f1}>Button</button><br />
        {/* <Level2Child firstName={firstName} age="22"/> */}
        Level1Child end <br />
    </>)
}