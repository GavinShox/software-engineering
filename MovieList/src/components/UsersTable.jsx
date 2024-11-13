import { useState, useEffect } from 'react';
import axios from 'axios';

function UsersTable() {
  const [users, setUsers] = useState([]);
  const [newUser, setNewUser] = useState({ firstname: '', lastname: '' });
  const [editingUser, setEditingUser] = useState(null);

  const fetchUsers = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/users');
      console.log(response.data._embedded.users);
      setUsers(response.data._embedded.users); // Adjusted for the JSON structure
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  // Create user
  const handleCreate = async () => {
    try {
      await axios.post('http://localhost:8080/api/users', newUser);
      fetchUsers();  // Refresh users list after creating
      setNewUser({ firstname: '', lastname: '' });
    } catch (error) {
      console.error('Error creating user:', error);
    }
  };

  // Update user
  const handleUpdate = async () => {
    try {
      await axios.put(`http://localhost:8080/api/users/${editingUser.userid}`, editingUser);
      fetchUsers();  // Refresh users list after updating
      setEditingUser(null);
    } catch (error) {
      console.error('Error updating user:', error);
    }
  };

  // Delete user
  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/users/${id}`);
      fetchUsers();  // Refresh users list after deleting
    } catch (error) {
      console.error('Error deleting user:', error);
    }
  };

  return (
    <div>
      <h2>Users</h2>

      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.userid}>  {/* ID starts at 1 not 0 */}
              <td>{user.firstname}</td>
              <td>{user.lastname}</td>
              <td>
                <button onClick={() => setEditingUser(user)}>Edit</button>
                <button onClick={() => handleDelete(user.userid)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Form for Create/Edit */}
      <div>
        <h3>{editingUser ? 'Edit User' : 'Add New User'}</h3>
        <input
          type="text"
          placeholder="First Name"
          value={editingUser ? editingUser.firstname : newUser.firstname}
          onChange={(e) =>
            editingUser
              ? setEditingUser({ ...editingUser, firstname: e.target.value })
              : setNewUser({ ...newUser, firstname: e.target.value })
          }
        />
        <input
          type="text"
          placeholder="Last Name"
          value={editingUser ? editingUser.lastname : newUser.lastname}
          onChange={(e) =>
            editingUser
              ? setEditingUser({ ...editingUser, lastname: e.target.value })
              : setNewUser({ ...newUser, lastname: e.target.value })
          }
        />
        <button onClick={editingUser ? handleUpdate : handleCreate}>
          {editingUser ? 'Update' : 'Create'}
        </button>
      </div>
    </div>
  );
}

export default UsersTable;
