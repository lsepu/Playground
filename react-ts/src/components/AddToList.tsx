import React, { useState } from "react";
import { IState as Props } from "../App"

//define the props in the interface
interface IProps {
    people: Props["people"]
    setPeople: React.Dispatch<React.SetStateAction<Props["people"]>>
}

//then add the props in the generic of what is going to exepct
const AddToList: React.FC<IProps> = ({people, setPeople}) => {

    const [input, setInput] = useState({
        name: "",
        age: "",
        note: "",
        img: ""
    })

    //handle events
    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>): void => {
        setInput({
            ...input,
            [e.target.name] : e.target.value
        })
    }

    const handleClick = () : void =>  {
        if(
            !input.name ||
            !input.age ||
            !input.img
        ) {
            return
        }

        setPeople([
            ...people,
            {
                name: input.name,
                age: parseInt(input.age),
                img: input.img,
                note: input.note
            }
        ])

        //clear
        setInput({
            name: "",
            age: "",
            note: "",
            img: ""
        })
    }

  return (
    <div className="AddToList">
      <input type="text" placeholder="Name" className="AddToList-input" value={input.name} onChange={handleChange} name="name"/>
      <input type="text" placeholder="Age" className="AddToList-input" value={input.age} onChange={handleChange} name="age"/>
      <input type="text" placeholder="Image Url" className="AddToList-input" value={input.img} onChange={handleChange} name="img"/>
      <textarea  placeholder="Notes" className="AAddToList-input" value={input.note} onChange={handleChange} name="note"/>
      <button className="AddToList-btn" onClick={handleClick}> Add to List </button>
    </div>
  );
};

export default AddToList;
