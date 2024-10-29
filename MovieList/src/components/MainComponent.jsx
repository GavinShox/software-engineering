import FormComponent from './FormComponent';
import DisplayComponent from './DisplayComponent';


function MainComponent() {
  return (
    <div className='mainTitle'>
      <h1 className="title">Profile Manager</h1>
      <div className="inputDetails">
      <FormComponent />
      </div>
      <div className="profileDetails">
      <DisplayComponent />
      </div>
    </div>
  );
}

export default MainComponent;
