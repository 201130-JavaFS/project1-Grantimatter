const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: {
        navigation: './src/Navigation.js',
        reimbursements: ['./src/reimbursements/ReimbursementUtil.js', './src/reimbursements/CreateReimbursement.js' , './src/reimbursements/ReimbursementDisplay.js'],
        login: ['./src/Login.js', './src/LoginModal.js'],
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Revature ERS',
        }),
    ],
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
  module: {
    rules: [
        {
            test: /\.css$/i,
            use: ['style-loader', 'css-loader']
        },
    ],
  },
};