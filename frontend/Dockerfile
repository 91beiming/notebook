FROM node:20.13.0-slim as build-stage
WORKDIR /app
COPY . .
RUN npm install --location=global pnpm@9.1.0 && pnpm install && pnpm build

FROM nginx:1.25.5-alpine AS prod-stage
WORKDIR /html
COPY --from=build-stage /app/dist /html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]