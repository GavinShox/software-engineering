import { useState, useContext } from 'react';
import { AppContext } from '../context/AppContext';

function FormComponent() {
  const { setProfile } = useContext(AppContext); // use setProfile from context
  const [formData, setFormData] = useState({ name: '', email: '', age: '' });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setProfile(formData); // save form data to context
  };

  return (
    <form onSubmit={handleSubmit} className="container">
      <div className="field">
        <label>Name: </label>
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
        />
      </div>
      <div className="field">
        <label>Email: </label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
        />
      </div>
      <div className="field">
        <label>Age: </label>
        <input
          type="number"
          name="age"
          value={formData.age}
          onChange={handleChange}
        />
      </div>
      <button type="submit" className="button">Save Profile</button>
    </form>
  );
}

export default FormComponent;
