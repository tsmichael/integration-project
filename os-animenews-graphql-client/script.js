const selectChoise = document.getElementById("select-search");
const panel = document.getElementById("div-panel");
const input = document.getElementById("inputId");
const searchButton = document.getElementById("search-all-button");

let table = document.createElement("table");
let thead = document.createElement("thead");
let tbody = document.createElement("tbody");

table.appendChild(thead);
table.appendChild(tbody);

document.getElementById("body").appendChild(table);
//table-header
let table_header = document.createElement("tr");

let header_column_id = document.createElement("th");
header_column_id.innerHTML = "ArticleID";
let header_column_title = document.createElement("th");
header_column_title.innerHTML = "Title";
let header_column_author = document.createElement("th");
header_column_author.innerHTML = "Author";
let header_column_date = document.createElement("th");
header_column_date.innerHTML = "Date";
let header_column_description = document.createElement("th");
header_column_description.innerHTML = "Info";

table_header.appendChild(header_column_id);
table_header.appendChild(header_column_title);
table_header.appendChild(header_column_author);
table_header.appendChild(header_column_date);

thead.appendChild(table_header);

function clickOption() {
  if (input.value == "") {
    const newbody = document.createElement("tbody");
    table.replaceChild(newbody, tbody);
    loadAll();
    tbody = newbody;
  } else {
    const newbody = document.createElement("tbody");
    table.replaceChild(newbody, tbody);
    loadById(parseInt(input.value));
    tbody = newbody;
  }
}

function loadAll() {
  queryFetch(
    `
    query{
        articles{
          id,
          title,
          description,
          author,
          date
        }
      }
    `
  ).then((data) => {
    data.data.articles.forEach((article) => {
      const row = document.createElement("tr");

      const id = document.createElement("th");
      id.innerText = article.id;

      const title = document.createElement("th");
      title.innerText = article.title;

      const author = document.createElement("th");
      author.innerText = article.author;

      const date = document.createElement("th");
      date.innerText = article.date;

      const description_button = document.createElement("button");
      description_button.id = "circle-button";
      description_button.innerText = "i";
      description_button.addEventListener("click", function () {
        alert(article.description);
      });

      row.append(id);
      row.append(title);
      row.append(author);
      row.append(date);
      row.append(description_button);
      tbody.appendChild(row);
    });
  });
}

function loadById(id) {
  queryFetch(
    `
        query getId($id: Int!){
        articleById(id: $id){
          id,
          title,
          description,
          author,
          date
        }
      }`,
    { id: id }
  ).then((data) => {
    const articleByIds = data.data.articleById;
    const row = document.createElement("tr");

    const id = document.createElement("th");
    id.innerText = articleByIds.id;

    const title = document.createElement("th");
    title.innerText = articleByIds.title;

    const author = document.createElement("th");
    author.innerText = articleByIds.author;

    const date = document.createElement("th");
    date.innerText = articleByIds.date;

    const description_button = document.createElement("button");
    description_button.id = "circle-button";
    description_button.innerText = "i";
    description_button.addEventListener("click", function () {
      alert(articleByIds.description);
    });

    row.append(id);
    row.append(title);
    row.append(author);
    row.append(date);
    row.append(description_button);
    tbody.appendChild(row);
  });
}

function queryFetch(query, variables) {
  return fetch("http://localhost:8889/graphql", {
    method: "POST",
    headers: { "content-type": "aplication/json" },
    body: JSON.stringify({
      query: query,
      variables: variables,
    }),
  }).then((res) => res.json());
}
