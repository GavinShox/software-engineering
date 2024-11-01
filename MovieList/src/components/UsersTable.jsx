import { useState, useEffect } from 'react';
import axios from 'axios';

function UsersTable() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/users');
        setUsers(response.data._embedded.users); // Adjusted for the JSON structure
      } catch (error) {
        console.error('Error fetching movies:', error);
      }
    };
    fetchUsers();
  }, []);

  return (
    <table>
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
        </tr>
      </thead>
      <tbody>
        {users.map((user) => (
          <tr key={user.id}>
            <td>{user.firstname}</td>
            <td>{user.lastname}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default UsersTable;
