import { AppProvider } from './context/AppContext';
import MainComponent from './components/MainComponent'; // Import MainComponent
import MoviesTable from './components/MoviesTable';
import UsersTable from './components/UsersTable';
import './App.css';

function App() {
  return (
    <AppProvider>
      <div className="mainComponent">
        <MainComponent />
      </div>
      <div className="moviesTable">
        <MoviesTable />
      </div>
      <div className="usersTable">
        <UsersTable />
      </div>
    </AppProvider>
  );
}

export default App;
