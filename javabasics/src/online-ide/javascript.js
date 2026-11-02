async function runCode(){

    let code = document.getElementById("editor").value;

    let response = await fetch("https://emkc.org/api/v2/piston/execute", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            language: "python",
            version: "3.10.0",
            files: [
                {
                    content: code
                }
            ]
        })
    });

    let data = await response.json();

    document.getElementById("output").textContent =
        data.run.output;
}