FROM quay.io/quarkus/quarkus-micro-image:2.0
LABEL dev="Robin Bartenstein"
LABEL contact="dev@ge1st.xyz"
WORKDIR /work/
COPY target/*-runner /work/application
COPY target/compare/index.html /work/compare/index.html
COPY target/compare/styles-dark.css /work/compare/styles-dark.css
RUN chmod 775 /work/*
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]