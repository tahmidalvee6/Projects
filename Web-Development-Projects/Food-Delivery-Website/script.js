// Sign In/ Sign Out
let signedIn = false;
const authBtn = document.getElementById('authBtn');

authBtn.addEventListener('click', () => {
  if (!signedIn) {
    const name = prompt("Enter your name to Sign In:");
    if (name) {
      signedIn = true;
      authBtn.textContent = `Sign Out (${name})`;
      alert(`Welcome, ${name}!`);
    }
  } else {
    signedIn = false;
    authBtn.textContent = "Sign In";
    alert("You signed out.");
  }
});

// Cart
let cart = [];
let total = 0;

function addToCart(name, price) {
  if (!signedIn) {
    alert("Please Sign In first!");
    return;
  }
  cart.push({ name, price });
  total += price;
  updateCartDisplay();
}

function updateCartDisplay() {
  const cartItems = document.getElementById('cartItems');
  const totalDisplay = document.getElementById('total');
  cartItems.innerHTML = "";
  cart.forEach((item) => {
    const li = document.createElement('li');
    li.textContent = `${item.name} - $${item.price.toFixed(2)}`;
    cartItems.appendChild(li);
  });
  totalDisplay.textContent = total.toFixed(2);
}

function checkout() {
  if (cart.length === 0) {
    alert("Your cart is empty!");
    return;
  }
  alert(`Order placed! Total: $${total.toFixed(2)}`);
  cart = [];
  total = 0;
  updateCartDisplay();
}

// Contact
const contactForm = document.getElementById('contactForm');
const modal = document.getElementById('contactModal');
const closeModal = document.querySelector('.close');

contactForm.addEventListener('submit', (e) => {
  e.preventDefault();
  
  
  modal.style.display = "block";
  
  
  contactForm.reset();
});


closeModal.addEventListener('click', () => {
  modal.style.display = "none";
});


window.addEventListener('click', (e) => {
  if (e.target == modal) {
    modal.style.display = "none";
  }
});

