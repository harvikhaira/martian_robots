<html>
    <head>
        <style>
            input[type=text], textarea {
                height:250px;
                width:350px;
            }

            #input {
                float:left;
                width:50%;
            }

            #output {
                float:right;
                width:50%;
            }
        </style>
    </head>
    <body>
        <h1>Red Badger - Martian Robots challenge</h1>
        <div id="input">
            <h2>Input:</h2>
            <p>Please input Robot instructions (including initial grid boundary co-ordinates)</p>
            <textarea id="inp_instructions"></textarea>
            <input type="button" id="inp_submit" value="Submit"/>
        </div>
        <div id="output">
            <h2>Output:</h2>
            <input type="text" id="inp_output" disabled="disabled" />
        </div>

        <script src="webjars/jquery/3.2.1/jquery.min.js" ></script>
        <script type="text/javascript" src="resources/home.js" ></script>
    </body>
</html>
