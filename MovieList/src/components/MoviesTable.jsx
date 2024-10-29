import { useState, useEffect } from 'react';
import axios from 'axios';

function MoviesTable() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/movies');
        setMovies(response.data._embedded.movies); // Adjusted for the JSON structure
      } catch (error) {
        console.error('Error fetching movies:', error);
      }
    };
    fetchMovies();
  }, []);

  return (
    <table>
      <thead>
        <tr>
          <th>Movie Name</th>
          <th>Director</th>
          <th>Date of Release</th>
        </tr>
      </thead>
      <tbody>
        {movies.map((movie) => (
          <tr key={movie.movieid}>
            <td>{movie.moviename}</td>
            <td>{movie.director}</td>
            <td>{movie.dateofrelease}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default MoviesTable;
