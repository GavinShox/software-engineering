import { AppProvider } from './context/AppContext';
import MainComponent from './components/MainComponent'; // Import MainComponent

function App() {
  return (
    <AppProvider>
      <MainComponent />
    </AppProvider>
  );
}

export default App;
