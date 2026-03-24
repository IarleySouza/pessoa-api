# Pessoa API

## Project Description
The Pessoa API is a RESTful web service designed to handle personal information management. It provides various endpoints to create, retrieve, update, and delete personal records.

## Technology Stack
- **Node.js**: Server-side JavaScript runtime environment.
- **Express.js**: Web framework for Node.js.
- **MongoDB**: NoSQL database for storing personal records.
- **Mongoose**: MongoDB object modeling tool designed to work in an asynchronous environment.

## Project Structure
```
/pessoa-api
├── /models       # Mongoose models
├── /routes       # API route definitions
├── /controllers  # Logic behind each route
├── /config       # Configuration files
├── /middleware    # Middleware functions
├── server.js     # Entry point for the application
└── package.json   # NPM package configuration
```

## Prerequisites
- [Node.js](https://nodejs.org/) (12.x or later)
- [MongoDB](https://www.mongodb.com/) (Make sure the MongoDB server is running)
- NPM (Node Package Manager)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/IarleySouza/pessoa-api.git
   cd pessoa-api
   ```
2. Install the dependencies:
   ```bash
   npm install
   ```
3. Set up environment variables (if necessary) in a `.env` file.
4. Start the server:
   ```bash
   npm start
   ```
5. Access the API at `http://localhost:3000`.

## API Endpoints
- `GET /pessoa` - Retrieve all personal records
- `POST /pessoa` - Create a new personal record
- `GET /pessoa/:id` - Retrieve a personal record by ID
- `PUT /pessoa/:id` - Update a personal record by ID
- `DELETE /pessoa/:id` - Delete a personal record by ID

For further details, refer to the API documentation or the project wiki.