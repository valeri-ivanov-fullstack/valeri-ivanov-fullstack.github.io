# Step 1: Build the Angular application with the latest stable Node.js
FROM node:18 AS build  # Using Node.js 18 (latest LTS as of October 2023)
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Step 2: Serve the application with the latest stable NGINX
FROM nginx:stable-alpine
COPY --from=build /app/dist/frontend /usr/share/nginx/html

# Expose the frontend port
EXPOSE 80
