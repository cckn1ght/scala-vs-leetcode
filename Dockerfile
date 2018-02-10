# specify the node base image with your desired version node:<version>
FROM node:8
# replace this with your application's default port
EXPOSE 4000
RUN npm i