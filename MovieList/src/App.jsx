import { AppProvider } from './context/AppContext';
import MainComponent from './components/MainComponent'; // Import MainComponent
import MoviesTable from './components/MoviesTable';

function App() {
  return (
    <AppProvider>
      <div className="mainComponent">
        <MainComponent />
      </div>
      <div className="moviesTable">
        <MoviesTable />
      </div>
    </AppProvider>
  );
}

export default App;
