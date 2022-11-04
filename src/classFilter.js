import React from 'react';
import ReactDOM from 'react-dom';

class Form extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      agreement: false
    };
  }

  handleChange = e => this.setState({ agreement: e.target.checked });
  handleSubmit = e => {
    e.preventDefault();
    console.log(`checked: ${this.state.agreement}`);
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>
            <input type="checkbox" checked={this.state.agreement} onChange={this.handleChange} />
            <span>Consent to the data processing</span>
          </label>
        </div>
        <button type="submit">Submit</button>
      </form>
    );
  }
};

const root = document.querySelector('#root');
ReactDOM.render(<Form />, root);