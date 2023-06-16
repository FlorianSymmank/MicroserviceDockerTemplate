# --- Development build stage ---
FROM node:14 AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# --- Production stage ---
FROM nginx:stable-alpine
COPY --from=build-stage /app/build /usr/share/nginx/html
# Copy the Nginx configuration file
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
# Expose the HTTP port
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
