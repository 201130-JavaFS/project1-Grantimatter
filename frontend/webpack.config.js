const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: {
        navigation: './src/Navigation.js',
        reimbursements: ['./src/reimbursements/Reimbursement.js', './src/reimbursements/ReimbursementUtil.js'],
        login: './src/LoginModal.js',
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Output Management',
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