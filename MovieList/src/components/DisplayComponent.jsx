import { useContext } from 'react';
import { AppContext } from '../context/AppContext';

function DisplayComponent() {
  const { profile } = useContext(AppContext); // access profile from context

  return (
    <div>
      <h2>Profile Details</h2>
      <p>Name: {profile.name}</p>
      <p>Email: {profile.email}</p>
      <p>Age: {profile.age}</p>
    </div>
  );
}

export default DisplayComponent;
