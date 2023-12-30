# Use the official node image as a base image
FROM node:21.5.0-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the node-related files
COPY package.json ./
COPY package-lock.json ./

# Install the packages
RUN npm install

# Copy the source code files
COPY . ./

# Build the node app
RUN npm run build

# Use the stable nginx image as a deploy image
FROM nginx:stable

# Copy the compiled html to nginx
# COPY --from=build /app/dist /usr/share/nginx/html
COPY --from=build /app/dist /etc/nginx/html

# Remove the default Nginx configuration
RUN rm /etc/nginx/conf.d/default.conf

# Copy your custom Nginx configuration file
COPY nginx.conf /etc/nginx/conf.d/