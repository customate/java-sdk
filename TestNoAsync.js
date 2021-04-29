const uri = process.argv.slice(3)[0];
console.log('uri passed to JS file: ' + uri);
set fso = CreateObject("Scripting.FileSystemObject");
set s   = fso.CreateTextFile("test-result.txt", True);
s.writeline("Success");
s.Close();