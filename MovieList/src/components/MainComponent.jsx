import FormComponent from './FormComponent';
import DisplayComponent from './DisplayComponent';

function MainComponent() {
  return (
    <div className='mainTitle'>
      <h1>Main Component</h1>
      <FormComponent />
      <DisplayComponent />
    </div>
  );
}

export default MainComponent;
