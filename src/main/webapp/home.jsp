<html>
    <head>
        <style>
            input[type=text] {
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
            <input type="text" name="inp_instructions"/>
            <input type="button" name="inp_submit" value="Submit"/>
        </div>
        <div id="output">
            <h2>Output:</h2>
            <input type="text" disabled="disabled" />
        </div>
    </body>
</html>
