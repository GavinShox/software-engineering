import FormComponent from './FormComponent';
import DisplayComponent from './DisplayComponent';

function MainComponent() {
  return (
    <div className='mainTitle'>
      <h1>Profile Manager</h1>
      <FormComponent />
      <DisplayComponent />
    </div>
  );
}

export default MainComponent;
