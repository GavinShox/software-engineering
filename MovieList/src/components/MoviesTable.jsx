import { useState, useEffect } from 'react';
import axios from 'axios';

function MoviesTable() {
  const [movies, setMovies] = useState([]);
  const [newMovie, setNewMovie] = useState({ moviename: '', director: '', dateofrelease: '' });
  const [editingMovie, setEditingMovie] = useState(null);

  // Fetch movies function, defined outside of useEffect
  const fetchMovies = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/movies');
      setMovies(response.data._embedded.movies);
    } catch (error) {
      console.error('Error fetching movies:', error);
    }
  };

  // Call fetchMovies on component mount
  useEffect(() => {
    fetchMovies();
  }, []);

  // Create movie
  const handleCreate = async () => {
    try {
      await axios.post('http://localhost:8080/api/movies', newMovie);
      fetchMovies();  // Refresh movies list after creating
      setNewMovie({ moviename: '', director: '', dateofrelease: '' });
    } catch (error) {
      console.error('Error creating movie:', error);
    }
  };

  // Update movie
  const handleUpdate = async () => {
    try {
      await axios.put(`http://localhost:8080/api/movies/${editingMovie.movieid}`, editingMovie);
      fetchMovies();  // Refresh movies list after updating
      setEditingMovie(null);
    } catch (error) {
      console.error('Error updating movie:', error);
    }
  };

  // Delete movie
  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/movies/${id}`);
      fetchMovies();  // Refresh movies list after deleting
    } catch (error) {
      console.error('Error deleting movie:', error);
    }
  };

  return (
    <div>
      <h2>Movies</h2>
      <table>
        <thead>
          <tr>
            <th>Movie Name</th>
            <th>Director</th>
            <th>Date of Release</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {movies.map((movie) => (
            <tr key={movie.movieid}>
              <td>{movie.moviename}</td>
              <td>{movie.director}</td>
              <td>{movie.dateofrelease}</td>
              <td>
                <button onClick={() => setEditingMovie(movie)}>Edit</button>
                <button onClick={() => handleDelete(movie.movieid)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Form for Create/Edit */}
      <div>
        <h3>{editingMovie ? 'Edit Movie' : 'Add New Movie'}</h3>
        <input
          type="text"
          placeholder="Name"
          value={editingMovie ? editingMovie.moviename : newMovie.moviename}
          onChange={(e) =>
            editingMovie
              ? setEditingMovie({ ...editingMovie, moviename: e.target.value })
              : setNewMovie({ ...newMovie, moviename: e.target.value })
          }
        />
        <input
          type="text"
          placeholder="Director"
          value={editingMovie ? editingMovie.director : newMovie.director}
          onChange={(e) =>
            editingMovie
              ? setEditingMovie({ ...editingMovie, director: e.target.value })
              : setNewMovie({ ...newMovie, director: e.target.value })
          }
        />
        <input
          type="date"
          placeholder="Release Date"
          value={editingMovie ? editingMovie.dateofrelease : newMovie.dateofrelease}
          onChange={(e) =>
            editingMovie
              ? setEditingMovie({ ...editingMovie, dateofrelease: e.target.value })
              : setNewMovie({ ...newMovie, dateofrelease: e.target.value })
          }
        />
        <button onClick={editingMovie ? handleUpdate : handleCreate}>
          {editingMovie ? 'Update' : 'Create'}
        </button>
      </div>
    </div>
  );
}

export default MoviesTable;
