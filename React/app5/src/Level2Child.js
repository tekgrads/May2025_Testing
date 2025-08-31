import Level3Child from './Level3Child';
export default function Level2Child({firstName, age}) {
    return (<>
        Level2Child begin { firstName } <br /> {age}<br />
        <Level3Child />
        Level2Child end <br />
    </>)
}