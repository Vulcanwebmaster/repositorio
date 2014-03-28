using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace RecHLockNew
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            grbOptions.Left = (this.ClientSize.Width - grbOptions.Width) / 2;
            btnEntrar.Left = (this.ClientSize.Width - btnEntrar.Width) / 2;
        }

        private void btnEntrar_Click(object sender, EventArgs e)
        {
            this.Hide();

            Form frmMain = new FormMain();
            frmMain.ShowDialog();

            this.Close();

        }
    }
}